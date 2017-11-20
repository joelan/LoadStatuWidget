# 加载状态布局切换工具
![image](https://github.com/joelan/LoadStatuWidget/raw/master/screenshoot/1.png)
![image](https://github.com/joelan/LoadStatuWidget/raw/master/screenshoot/2.png)
![image](https://github.com/joelan/LoadStatuWidget/raw/master/screenshoot/3.png)
![image](https://github.com/joelan/LoadStatuWidget/raw/master/screenshoot/4.png)
## 1.依赖
### 依赖库分发在Jcenter。
```java

 repositories { 
        jcenter()
   }

dependencies {
compile 'com.joe.animationtool:loadinglibrary:1.0.1'
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


