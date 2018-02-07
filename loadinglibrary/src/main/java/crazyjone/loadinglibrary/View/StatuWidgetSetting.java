package crazyjone.loadinglibrary.View;

/**
 * Created by Administrator on 2017/11/17.
 */

public class StatuWidgetSetting {

    LoadingSetting  loadingSetting;
    NetworkSetting networkSetting;
    EmptySetting  emptySetting;

    public EmptySetting getEmptySetting() {
        return emptySetting;
    }

    public void setEmptySetting(EmptySetting emptySetting) {
        this.emptySetting = emptySetting;
    }

    public LoadingSetting getLoadingSetting() {
        return loadingSetting;
    }

    public void setLoadingSetting(LoadingSetting loadingSetting) {
        this.loadingSetting = loadingSetting;
    }

    public NetworkSetting getNetworkSetting() {
        return networkSetting;
    }

    public void setNetworkSetting(NetworkSetting networkSetting) {
        this.networkSetting = networkSetting;
    }

  public   class LoadingSetting
    {

        /**
         * @param bagroundcolor
         * @param loading_iamge_res  0的时候默认加载
         * @param loadingstr
         * @param loading_image_width  0的时候自适应
         * @param loading_image_height 0的时候自适应
         */
        public  LoadingSetting(int bagroundcolor,int loading_iamge_res,String loadingstr,int loading_image_width,int loading_image_height)
        {
            this.bagroundcolor=bagroundcolor;
            this.loading_iamge_res=loading_iamge_res;
            this.loadingstr=loadingstr;
            this.loading_image_width=loading_image_width;
            this.loading_image_height=loading_image_height;

        }

        public int getBagroundcolor() {
            return bagroundcolor;
        }

        public void setBagroundcolor(int bagroundcolor) {
            this.bagroundcolor = bagroundcolor;
        }

        public int getLoading_iamge_res() {
            return loading_iamge_res;
        }

        public void setLoading_iamge_res(int loading_iamge_res) {
            this.loading_iamge_res = loading_iamge_res;
        }

        public String getLoadingstr() {
            return loadingstr;
        }

        public void setLoadingstr(String loadingstr) {
            this.loadingstr = loadingstr;
        }

        public int getLoading_image_width() {
            return loading_image_width;
        }

        public void setLoading_image_width(int loading_image_width) {
            this.loading_image_width = loading_image_width;
        }

        public int getLoading_image_height() {
            return loading_image_height;
        }

        public void setLoading_image_height(int loading_image_height) {
            this.loading_image_height = loading_image_height;
        }

        private int bagroundcolor;
       private int loading_iamge_res;
        private  String  loadingstr;
        private int  loading_image_width;
        private  int loading_image_height;

        public float getTextsize() {
            return textsize;
        }

        public void setTextsize(float textsize) {
            this.textsize = textsize;
        }

        public int getTextcolorres() {
            return textcolorres;
        }

        public void setTextcolorres(int textcolorres) {
            this.textcolorres = textcolorres;
        }

        private   float textsize;
        private   int textcolorres;


    }

    public  class NetworkSetting
    {

        /**
         * @param bagroundcolor
         * @param network_image_res  0的时候默认图
         * @param network_str
         * @param network_image_width 0的时候自适应
         * @param network_image_height 0的时候自适应
         */
        public  NetworkSetting( int bagroundcolor, int network_image_res,    String  network_str,int  network_image_width,int network_image_height)
        {

            this.bagroundcolor=bagroundcolor;
            this.network_image_res=network_image_res;
            this.network_str=network_str;
            this.network_image_width=network_image_width;
            this.network_image_height=network_image_height;


        }
        public int getBagroundcolor() {
            return bagroundcolor;
        }

        public void setBagroundcolor(int bagroundcolor) {
            this.bagroundcolor = bagroundcolor;
        }

        public int getNetwork_image_res() {
            return network_image_res;
        }

        public void setNetwork_image_res(int network_image_res) {
            this.network_image_res = network_image_res;
        }

        public String getNetwork_str() {
            return network_str;
        }

        public void setNetwork_str(String network_str) {
            this.network_str = network_str;
        }

        public int getNetwork_image_width() {
            return network_image_width;
        }

        public void setNetwork_image_width(int network_image_width) {
            this.network_image_width = network_image_width;
        }

        public int getNetwork_image_height() {
            return network_image_height;
        }

        public void setNetwork_image_height(int network_image_height) {
            this.network_image_height = network_image_height;
        }

        private   int bagroundcolor;
        private   int network_image_res;

        public float getTextsize() {
            return textsize;
        }

        public void setTextsize(float textsize) {
            this.textsize = textsize;
        }

        public int getTextcolorres() {
            return textcolorres;
        }

        public void setTextcolorres(int textcolorres) {
            this.textcolorres = textcolorres;
        }

        private   String  network_str;
        private   int  network_image_width;
        private   int network_image_height;

        private   float textsize;
        private   int textcolorres;

    }

    public class EmptySetting
    {
        public boolean isShwicon() {
            return isShowicon;
        }

        public void setShwicon(boolean shwicon) {
            isShowicon = shwicon;
        }

        public  EmptySetting(int bagroundcolor, int empty_image_res, String  empty_str, int  empty_image_width, int empty_image_height, boolean isShwicon)
        {

            this.bagroundcolor=bagroundcolor;
            this.empty_image_res=empty_image_res;
            this.empty_str=empty_str;
            this.empty_image_width=empty_image_width;
            this.empty_image_height=empty_image_height;
            this.isShowicon=isShwicon;


        }
        public int getBagroundcolor() {
            return bagroundcolor;
        }

        public void setBagroundcolor(int bagroundcolor) {
            this.bagroundcolor = bagroundcolor;
        }

        public int getEmpty_image_res() {
            return empty_image_res;
        }

        public void setEmpty_image_res(int empty_image_res) {
            this.empty_image_res = empty_image_res;
        }

        public String getEmpty_str() {
            return empty_str;
        }

        public void setEmpty_str(String empty_str) {
            this.empty_str = empty_str;
        }

        public int getEmpty_image_width() {
            return empty_image_width;
        }

        public void setEmpty_image_width(int empty_image_width) {
            this.empty_image_width = empty_image_width;
        }

        public int getEmpty_image_height() {
            return empty_image_height;
        }

        public void setEmpty_image_height(int empty_image_height) {
            this.empty_image_height = empty_image_height;
        }

        public float getTextsize() {
            return textsize;
        }

        public void setTextsize(float textsize) {
            this.textsize = textsize;
        }

        public int getTextcolorres() {
            return textcolorres;
        }

        public void setTextcolorres(int textcolorres) {
            this.textcolorres = textcolorres;
        }

        private   int bagroundcolor;
        private   int empty_image_res;
        private   String  empty_str;

        private   float textsize;
        private   int textcolorres;
        private   int  empty_image_width;
        private   int empty_image_height;
        private  boolean isShowicon=true;
    }
}

