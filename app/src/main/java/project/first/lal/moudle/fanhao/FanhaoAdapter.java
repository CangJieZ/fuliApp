package project.first.lal.moudle.fanhao;

import android.content.Context;
import android.first.lal.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import project.first.lal.common.utils.recycle.FootHolderAdapter;
import project.first.lal.common.utils.recycle.LoadMoreInterface;

/**
 * user:zhuwt
 *
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @ClassName: ${type_name}.java
 * 2017/1/20
 * @说明 代码版权归 作者 所有
 */
public class FanhaoAdapter extends FootHolderAdapter<FanhaoAdapter.FanhaoHolder> {

    private Context mContext;
    private ArrayList<DesignationModel> mList;
    private LoadMoreInterface mLoadMoreInterface;

    public FanhaoAdapter(ArrayList<DesignationModel> data, FanhaoActivity activity) {
        this.mList = data;
        this.mContext = activity;
        mLoadMoreInterface = activity;
        setList(mList);
        setLayoutId(R.layout.fanhao_item);
        setBaseActivity(activity);
    }

    //刷新数据 重新设置数据源
    void setData(ArrayList<DesignationModel> data) {
        mList.addAll(data);
        setList(mList);
        onLoadMore(false);
        notifyDataSetChanged();
    }

    @Override
    public FanhaoHolder createViewHolder(ViewGroup parent) {
        return new FanhaoHolder(parent);
    }

    @Override
    public void onLoadMore(boolean loadMore) {
        mLoadMoreInterface.loadMore(loadMore);
    }

    @Override
    public void onBindHolder(FanhaoHolder holder, int position) {
        DesignationModel model = mList.get(position);
        Glide.with(mContext).load(model.getLink()).into(holder.img);
        holder.fanhao.setText(model.getFanhao());
        holder.source.setText(model.getScore() + "");
        holder.time.setText(model.getReleaseTime());
        holder.company.setText(model.getFilmDistributor());
        holder.actress.setText(model.getActress());
        holder.lael.setText(model.getLabel());
    }

    static class FanhaoHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView fanhao;
        private TextView source;
        private TextView time;
        private TextView company;
        private TextView actress;
        private TextView lael;

        public FanhaoHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.fanhao_item_img2);
            fanhao = (TextView) itemView.findViewById(R.id.fanhao_item_fanhao);
            source = (TextView) itemView.findViewById(R.id.fanhao_item_source);
            time = (TextView) itemView.findViewById(R.id.fanhao_item_time);
            company = (TextView) itemView.findViewById(R.id.fanhao_item_company);
            actress = (TextView) itemView.findViewById(R.id.fanhao_item_actress);
            lael = (TextView) itemView.findViewById(R.id.fanhao_item_label);
        }
    }
}
