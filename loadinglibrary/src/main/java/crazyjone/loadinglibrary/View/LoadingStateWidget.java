package crazyjone.loadinglibrary.View;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import crazyjone.loadinglibrary.R;


/**
 * Created by Administrator on 2017/9/26.
 */

public class LoadingStateWidget {

    StatuWidgetSetting setting;

    public StatuWidgetSetting getSetting() {
        return setting;
    }

    public void setSetting(StatuWidgetSetting setting) {
        this.setting = setting;
    }

    Context context;

    ViewGroup rootview;
    ViewGroup parentview;
    RelativeLayout relativeLayout;

    ViewGroup viewcontainer;
    int position=0;
    ViewGroup.LayoutParams containerlp;

    public void setRetryListener(RetryListener retryListener) {
        this.retryListener = retryListener;
    }

    RetryListener retryListener;
    View StateView;
    public void Attach(Activity context)
    {
        this.context=context;

        normalState();
        rootview = getRootView(context);
        parentview = (ViewGroup) rootview.getParent();
    }

    public void Attach(ViewGroup container)
    {
        //this.context=context;
        this.viewcontainer=container;

        ViewGroup  containerparentgroup= (ViewGroup) container.getParent();
        ViewGroup.LayoutParams containerlp=container.getLayoutParams();

        parentview=containerparentgroup;
        this.containerlp=containerlp;
        rootview=viewcontainer;
        this.context= container.getContext();


        for(int i=0;i<containerparentgroup.getChildCount();i++)
        {
            if(containerparentgroup.getChildAt(i)==container)
            {
                position=i;
                break;
            }

        }



    }




    private ViewGroup getRootView(Activity context)
    {
        return (ViewGroup) ((ViewGroup)context.findViewById(android.R.id.content)).getChildAt(0);

    }

    public  void  loadingState()
    {

        if(context==null&&viewcontainer==null)
            return ;
        normalState();

        if(parentview!=null)
         parentview.removeView(rootview);
        relativeLayout =new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
        relativeLayout.addView(rootview,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

       // context.getResources().getIdentifier("loading","layout",context.getPackageName());

        View loadingview= LayoutInflater.from(context).inflate(context.getResources().getIdentifier("loading","layout",context.getPackageName()),null);


        ProgressBar progress= (ProgressBar) loadingview.findViewById(R.id.progressBar);
        LinearLayout loading_container= (LinearLayout) loadingview.findViewById(R.id.loading_container);
        ImageView  loading_icon=(ImageView)loadingview.findViewById(R.id.loading_icon);
        TextView  loading_str=(TextView)loadingview.findViewById(R.id.loading_str);

        if(setting!=null&&setting.getLoadingSetting()!=null)
        {
            if(setting.getLoadingSetting().getLoading_iamge_res()!=0)
            {
                progress.setVisibility(View.GONE);
                loading_icon.setVisibility(View.VISIBLE);
                loading_icon.setImageResource(setting.getLoadingSetting().getLoading_iamge_res());


                loading_icon.setLayoutParams(new RelativeLayout.LayoutParams(
                        setting.getLoadingSetting().getLoading_image_width()==0?RelativeLayout.LayoutParams.WRAP_CONTENT:setting.getLoadingSetting().getLoading_image_width(),
                        setting.getLoadingSetting().getLoading_image_height()==0?RelativeLayout.LayoutParams.WRAP_CONTENT:setting.getLoadingSetting().getLoading_image_height()));
            }
            else
            {
                progress.setVisibility(View.VISIBLE);
                loading_icon.setVisibility(View.GONE);
            }
            if(setting.getLoadingSetting().getBagroundcolor()!=0)
            {
                loading_container.setBackgroundColor(context.getResources().getColor(setting.getLoadingSetting().getBagroundcolor()));
            }

            if(!TextUtils.isEmpty(setting.getLoadingSetting().getLoadingstr()))
            {
                loading_str.setText(setting.getLoadingSetting().getLoadingstr());
            }
            if(setting.getLoadingSetting().getTextcolorres()!=0)
            {
                loading_str.setTextColor(context.getResources().getColor(setting.getLoadingSetting().getTextcolorres()));
            }
            if(setting.getLoadingSetting().getTextsize()!=0)
            {
                loading_str.setTextSize(setting.getLoadingSetting().getTextsize());
            }








        }

        StateView=loadingview;
        relativeLayout.addView(loadingview,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

        if(viewcontainer==null)
        parentview.addView(relativeLayout);
       else
        {
            parentview.addView(relativeLayout,containerlp);
        }
        StateView.setVisibility(View.VISIBLE);

    }

    public  void  networkState()
    {
        if(context==null&&viewcontainer==null)
            return ;
       /* normalState();
        rootview = getRootView(context);

        parentview = (ViewGroup) rootview.getParent();*/

        normalState();

        if(parentview!=null)
            parentview.removeView(rootview);
        relativeLayout =new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
        relativeLayout.addView(rootview,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

        View loadingview= LayoutInflater.from(context).inflate(context.getResources().getIdentifier("networkerror","layout",context.getPackageName()),null);

        LinearLayout network_error_contaner= (LinearLayout) loadingview.findViewById(R.id.network_error_contaner);

        TextView network_tips=(TextView)loadingview.findViewById(R.id.network_tips);


        ImageView  icon= (ImageView) loadingview.findViewById(R.id.network_iocn);

        if(setting!=null&&setting.getNetworkSetting()!=null)
        {

            if(setting.getNetworkSetting().getBagroundcolor()!=0)
            {
                network_error_contaner.setBackgroundColor(context.getResources().getColor(setting.getNetworkSetting().getBagroundcolor()));
            }

            if(!TextUtils.isEmpty(setting.getNetworkSetting().getNetwork_str()))
            {
                network_tips.setText(setting.getNetworkSetting().getNetwork_str());
            }

            if(setting.getNetworkSetting().getNetwork_image_res()!=0)
            {
                icon.setImageResource(setting.getNetworkSetting().getNetwork_image_res());
            }

            icon.setLayoutParams(new LinearLayout.LayoutParams(
                    setting.getNetworkSetting().getNetwork_image_width()==0?LinearLayout.LayoutParams.WRAP_CONTENT:setting.getNetworkSetting().getNetwork_image_width(),
                    setting.getNetworkSetting().getNetwork_image_height()==0?LinearLayout.LayoutParams.WRAP_CONTENT:setting.getNetworkSetting().getNetwork_image_height()));

            if(setting.getNetworkSetting().getTextcolorres()!=0)
            {
                network_tips.setTextColor(context.getResources().getColor(setting.getNetworkSetting().getTextcolorres()));
            }
            if(setting.getNetworkSetting().getTextsize()!=0)
            {
                network_tips.setTextSize(setting.getNetworkSetting().getTextsize());
            }


        }

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(retryListener!=null)
                    retryListener.onRetry();
            }
        });
        StateView=loadingview;
        relativeLayout.addView(loadingview,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
        if(viewcontainer==null)
            parentview.addView(relativeLayout);
        else
        {
            parentview.addView(relativeLayout,containerlp);
        }
        StateView.setVisibility(View.VISIBLE);

    }


    public  void  emptyState()
    {
        if(context==null&&viewcontainer==null)
            return ;
       /* normalState();
        rootview = getRootView(context);

        parentview = (ViewGroup) rootview.getParent();*/

        normalState();

        if(parentview!=null)
            parentview.removeView(rootview);
        relativeLayout =new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
        relativeLayout.addView(rootview,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

        View loadingview= LayoutInflater.from(context).inflate(context.getResources().getIdentifier("empty","layout",context.getPackageName()),null);

        LinearLayout empty_contaner= (LinearLayout) loadingview.findViewById(R.id.empty_contaner);

        TextView empty_tips=(TextView)loadingview.findViewById(R.id.empty_tips);


        ImageView  icon= (ImageView) loadingview.findViewById(R.id.empty_iocn);

        if(setting!=null&&setting.getEmptySetting()!=null)
        {

            if(setting.getEmptySetting().getBagroundcolor()!=0)
            {
                empty_contaner.setBackgroundColor(context.getResources().getColor(setting.getEmptySetting().getBagroundcolor()));
            }

            if(!TextUtils.isEmpty(setting.getEmptySetting().getEmpty_str()))
            {
                empty_tips.setText(setting.getEmptySetting().getEmpty_str());
            }

            if(setting.getEmptySetting().isShwicon()) {
                icon.setVisibility(View.VISIBLE);
                if (setting.getEmptySetting().getEmpty_image_res() != 0) {
                    icon.setImageResource(setting.getEmptySetting().getEmpty_image_res());
                }

                icon.setLayoutParams(new LinearLayout.LayoutParams(
                        setting.getEmptySetting().getEmpty_image_width() == 0 ? LinearLayout.LayoutParams.WRAP_CONTENT : setting.getEmptySetting().getEmpty_image_width(),
                        setting.getEmptySetting().getEmpty_image_height() == 0 ? LinearLayout.LayoutParams.WRAP_CONTENT : setting.getEmptySetting().getEmpty_image_height()));

            }
            else
            {
                icon.setVisibility(View.GONE);
            }


            if(setting.getEmptySetting().getTextcolorres()!=0)
            {
                empty_tips.setTextColor(context.getResources().getColor(setting.getNetworkSetting().getTextcolorres()));
            }
            if(setting.getEmptySetting().getTextsize()!=0)
            {
                empty_tips.setTextSize(setting.getNetworkSetting().getTextsize());
            }
        }

    /*    icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(retryListener!=null)
                    retryListener.onRetry();
            }
        });*/
        StateView=loadingview;
        relativeLayout.addView(loadingview,new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
        if(viewcontainer==null)
            parentview.addView(relativeLayout);
        else
        {
            parentview.addView(relativeLayout,containerlp);
        }
        StateView.setVisibility(View.VISIBLE);

    }



    public  void normalState() {
        if(context==null&&viewcontainer==null)
            return ;

        if(StateView!=null&&relativeLayout!=null) {
            parentview.removeView(relativeLayout);
            ((ViewGroup) rootview.getParent()).removeView(rootview);
            if(viewcontainer==null)
            parentview.addView(rootview, 0);
            else
            {
             parentview.addView(rootview,containerlp);
            }
            StateView = null;
            relativeLayout = null;
        }

    }


public  interface RetryListener
{
    void onRetry();

}

}
