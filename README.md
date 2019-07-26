# AOP_LOGIN
使用AOP切面，完成集中式登录架构设计、埋点统计。

# 使用场景
## 1、告别繁琐的行为统计
 通常会对用户的点击行为进行统计，耗时统计等等。采用传统的javac编译方式，会造成大量代码冗余，不利于维护，而且如果有300个埋点统计，那开发者的工作量比较大。而且无意义。使用AOP思想一个注解就可以搞定统计行为。
```
    @ClickBehavior("我的优惠券")
 ```
## 2、用户在进入购物车、优惠券、个人中心前，都要判断是否登录，未登录则跳转到登录页面。
通过一个注解搞定 ，AOP切面后，会在切入点判断。用户不用理会这些无聊的操作。

```
    @ClickBehavior("我的专区")
    @LoginCheck
    fun area(view: View) {
        Log.e(TAG, "开始跳转到 -> 我的专区 Activity")
        val intent = Intent(this, OtherActivity::class.java)
        startActivity(intent)
    }
 ```
