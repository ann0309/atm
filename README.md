# note

onActivityResult

若從上一個Activity返回前一個Activity要攜帶資料，不一定要使用Intent，可以使用ActivityResult Api(startActivityResult deprecated)。
https://iter01.com/546500.html
<img width="438" alt="截圖 2023-03-06 下午3 08 11" src="https://user-images.githubusercontent.com/65845037/223041840-8340b313-42cb-427f-b2e1-83bdbf2b9cf7.png">

startActivity(intent)和startActivityResult差別


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
sharedPreferences資料以key value方式儲存
sharedPreferences commit和apply的差異為何？
sharedPreferences 運作流程（以登入為例）：
使用者做登入>>若使用者登入成功，將使用者輸入的值寫進xml>>下一次開啟app>>到xml中用key取得需要的值>>將取到的值顯示在畫面上>>畫面上可看到之前輸入的東西








訊息匡：alertDialog
頁面底下的浮動訊息：toast


Firebase連接：手機要聯網路，android studio左上角億登入firebase帳號
