# note

onActivityResult

若從上一個Activity返回前一個Activity要攜帶資料，不一定要使用Intent，可以使用ActivityResult Api。
https://iter01.com/546500.html

步驟：
若A返回到Ｂ
A:設定 setResult(要傳遞的資料)，
B:
生成ActivityResultLauncher的物件，裡面有onActivityResult方法，在onActivityResult定義要做的事情
當A返回到Ｂ時，A會去呼叫onActivityResult方法
onActivityResult接收的參數是A畫面中setResult()所攜帶的資料
----------------------------------------------------------------
匿名類別？？？
----------------------------------------------------------------

查看sharepreference的資料：
adb shell進手機，/data/data/应用程序包名/shared_prefs


sharedPreferences:讓使用者在輸入一次資料後，下一次不用重新輸入
sharedPreferences commit和apply的差異為何？


訊息匡：alertDialog
頁面底下的浮動訊息：toast


Firebase連接：手機要聯網路，android studio左上角億登入firebase帳號
