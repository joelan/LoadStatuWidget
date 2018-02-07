# 加载状态布局切换工具
[ ![Download](https://api.bintray.com/packages/joelan/maven/LoadWidget/images/download.svg) ](https://bintray.com/joelan/maven/LoadWidget/_latestVersion)

![image](https://github.com/joelan/LoadStatuWidget/raw/master/screenshoot/1.png)
![image](https://github.com/joelan/LoadStatuWidget/raw/master/screenshoot/2.png)
![image](https://github.com/joelan/LoadStatuWidget/raw/master/screenshoot/3.png)
![image](https://github.com/joelan/LoadStatuWidget/raw/master/screenshoot/4.png)
##  版本更新说明
### 1.0.2版本添加了提示文字的大小和颜色
### 1.0.3版本修复位置偏移问题
### 1.0.4版本修复自定义选项不可设置的问题
## 1.依赖
### 依赖库分发在Jcenter。
```java

 repositories { 
        jcenter()
   }

dependencies {
compile 'com.joe.animationtool:loadinglibrary:1.0.5'
}
```

## 2.使用

```java
     //1.初始化工具并attach 容器布局，
      //contain要显示当前加载状态的容器布局
        LoadingStateWidget   state=new LoadingStateWidget();
        state.Attach(contain);
        
       //也可以直接Attach  关联activity，会自动找出Activity容器布局，
         LoadingStateWidget   state=new LoadingStateWidget();
        state.Attach(Activity);
        
       //2.
       //改变当前布局为正在加载状态
       state.loadingState();
       
        //改变当前容器布局为网络错误状态（一般没网，连接失败的情况下）
       state.networkState();
       
      //改变当前容器布局为空数据状态
         state.emptyState();
         
        //恢复原来的正常布局状态
       state.normalState();
       
       
     // 3.网络错误，点击布局重试回调
      state.setRetryListener(RetryListener retryListener) 
       

```

## 3.自定义设置
### （1）通过设置StatuWidgetSetting类到LoadingStateWidget
```java
 state.setSetting(StatuWidgetSetting)
 
```
### （2）StatuWidgetSetting类里包含了 LoadingSetting类和NetworkSetting 类还有EmptySetting类分别是正在加载状态和加载失败状态和空状态的时候自定义设置，里面包含了设置相对应状态的一些参数的settter和getter，自行根据需要修改。
###  里面提到的color 是R.color.xxx 这样的值，textsize是sp单位。



