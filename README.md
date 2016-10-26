# VariantsDemo
在Android Studio下使用Gradle，进行多版本代码管理的示例。
***
###需求
>目标：一套代码分成不同的分支版本，在同一个工程下管理这几个版本。

多个分支版本之间，通常有以下异同：

- 不同版本之间大部分代码相同，如果分成多个工程，修改一处功能就要多个工程同时修改，不便于管理及多人协作。
- 不同版本的UI样式不同，包括颜色、图标等资源、部分页面的代码等。
- 不同版本的manifest元素有不同，比如部分key值等。
- 不同版本包名不同。

> 解决方案：Android Studio中使用Gradle编译多种apk包依靠productFlavors功能实现。


***
###步骤

- ###准备好原始工程，在工程的build.gradle中定义productFlavors。

	![效果图](https://github.com/Jasonchenlijian/VariantsDemo/raw/master/screenshot/build1.png) 

	在这个主工程下面定义了两个分支版本，edition1和edition2，包名分别为com.clj.edition1和com.clj.edition2。还可以为其指定不同的版本号及proguardFiles等。其他没有特别指定的值，会默认为主工程defaultConfig中的值，相当于在productFlavors中重写了主工程的默认值，类似于Java中的Override。

- ###在src目录下新建相对应的文件夹存放每个分支与主版本之间不同的代码及资源。

	![效果图](https://github.com/Jasonchenlijian/VariantsDemo/raw/master/screenshot/build2.png)

- ###分支版本的目录需要和main的目录保持一致。

	![效果图](https://github.com/Jasonchenlijian/VariantsDemo/raw/master/screenshot/build3.png)

	edition1和edition2中的MainActivity代码不同，所以从main中抽离出来。PublicActivity1和PublicActivity2是不同版本之间一样的，所以仍然放在main中。两个版本的ic_launcher启动图标不同，所以都覆盖了main中的ic_launcher。需要注意的是，java文件夹中的文件，在分支版本和main中不能同事存在；而res中可以同时存在，分支会覆盖mian中的文件。

- ###manifest中的元素并不是覆盖的关系，而是合并的关系。

	![效果图](https://github.com/Jasonchenlijian/VariantsDemo/raw/master/screenshot/build4.png)
	![效果图](https://github.com/Jasonchenlijian/VariantsDemo/raw/master/screenshot/build5.png)
	
	示例中，edition2的manifest并没有对main的manifest中的application元素节点进行复写，假如在edition2的application元素添加 `android:supportsRtl="false"`就会和main中的`android:supportsRtl="true"`的冲突。另外edition2针对PublicActivity1添加了`android:screenOrientation="portrait"`属性，则会和main中的publicActivity的属性进行合并。