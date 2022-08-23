# HW 0823 part4實作

* 取得一個 list 只有 name，且不重複並排序的資料
    * [Bill, Brian, KZ]
    * API : http://localhost:8080/stream/users
  
* 取得一個 map，其 key 為 ID；value 為 name
    * 1. “Bill”
    * 2. “Brian”
    * API : http://localhost:8080/stream/users/valueAndName
    
* 取得第一筆 name = KZ 的資料
    * API : http://localhost:8080/stream/users/name 
    
* 將資料先依據 age 排序，再依據 ID 排序
    * API : http://localhost:8080/stream/users/ageId 
    
* 取得一個 string 為所有資料的 name, age|name, age
    * Bill, 13|KZ, 23
    * API : http://localhost:8080/stream/users/allName

* 參考資料：
    *  https://howtodoinjava.com/java8/java-stream-distinct-examples/
    *  https://youtu.be/FWoYpM-E3EQ
