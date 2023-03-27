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
匿名類別？？？泛型？inflate????
----------------------------------------------------------------
### 快捷鍵：
建構子,getter setter:command+N
繼承:
log：輸入logd+tab
將區塊變成method:Command+Option+M 
成為屬性(會移除private 及型態那些的。剩下名稱)：Command+Option+F
複寫：control+o
trycatch: option+cmd+t
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



----------------------------------------------------------------------
String[] functions;  //是個String型態的陣列，固定長度
List<String> functions;   //List ，只收集String型態的東西，不固定長度，集合的一種，資料可重複
--------------------------------------------------------------------
  Datasource-----Adapter----RecycleView
  
  
  RecycleView:顯示資料用
  Adapter:用來連接資料和RecycleView(UI)
  
  ViewHolder繼承RecyclerView.ViewHolder，想像這裡是儲存view的地方
  ViewHolder為RecyclerView的內部類別
  
  
  Adapterup 因為是抽像累，所以繼承他的RecycleViewAdapter需要去實作adapter的三個方法
  onCreateViewHolder: 產生recycleView時會去呼叫
  onBindViewHolder：設定一個格子裡要顯示的資料
  getItemCount
  
    //現去建立一個一般的class，之後再去extend他所需要的class
  
  
  
  recycleView中的itemView是啥？
  
  
  //現去建立一個一般的class，之後再去extend他所需要的class
  
  
  
  
  
  
  讀取json檔：
  InputStream:將數據讀取到程式中
  OutputStream:將數據由程式中輸出

  
