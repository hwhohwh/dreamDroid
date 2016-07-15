package net.reichholf.dreamdroid.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.reichholf.dreamdroid.R;
import net.reichholf.dreamdroid.helpers.ExtendedHashMap;
import net.reichholf.dreamdroid.helpers.Statics;
import net.reichholf.dreamdroid.helpers.enigma2.Picon;
import net.reichholf.dreamdroid.helpers.enigma2.Service;

import java.util.ArrayList;

/**
 * Created by Stephan on 03.02.2016.
 */
public class ZapAdapter extends BaseAdapter<ZapAdapter.ZapViewHolder> {
	private Context mContext;

	public ZapAdapter(Context context, ArrayList<ExtendedHashMap> data) {
		super(data);
		mContext = context;
	}

	@Override
	public ZapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View itemView = inflater.inflate(R.layout.zap_grid_item, parent, false);
		ZapViewHolder zvh = new ZapViewHolder(itemView);
		itemView.setTag(zvh);
		return zvh;
	}

	@Override
	public void onBindViewHolder(ZapViewHolder holder, int position) {
		ExtendedHashMap service = mData.get(position);
		if (service != null) {
			holder.serviceName.setVisibility(View.VISIBLE);
			holder.serviceName.setText(service.getString(Service.KEY_NAME));
			Picon.setPiconForView(mContext, holder.picon, service, Statics.TAG_PICON);
		}
	}

	static class ZapViewHolder extends RecyclerView.ViewHolder {
		ImageView picon;
		TextView serviceName;

		public ZapViewHolder(View itemView) {
			super(itemView);
			picon = (ImageView) itemView.findViewById(R.id.picon);
			serviceName = (TextView) itemView.findViewById(android.R.id.text1);
		}
	}
}
