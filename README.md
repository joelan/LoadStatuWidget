# 加载状态布局切换工具
## 1.依赖
### 依赖库分发在Jcenter。
```java

 repositories { 
        jcenter()
   }

dependencies {
compile 'com.joe.animationtool:loadinglibrary:1.0.0'
}
```

## 2.使用

```java

    //1.contain要显示加载状态，网络状态的容器布局
        LoadingStateWidget   state=new LoadingStateWidget();
        state.Attach(contain);
        
       //也可以直接Attach  当前Activity.
         LoadingStateWidget   state=new LoadingStateWidget();
        state.Attach(Activity);
        

```

## 3.自定义设置
（1）通过设置StatuWidgetSetting类到LoadingStateWidget
```java
 state.setSetting(StatuWidgetSetting)
 
```
（2）StatuWidgetSetting类里包含了 LoadingSetting类和
 NetworkSetting 类分别设置正在加载状态和加载失败状态，分别设置里面的成员变量值来自定义状态布局。


