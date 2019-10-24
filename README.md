#### Đây là một project vi dụ về Clean Architecture kết hợp với MVVM


##### 2.Clean Architecture

 ![Drag Racing](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/blob/master/image/cleanArchitecture.jpeg) |  ![Drag Racing](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/blob/master/image/cleanArchitecture2.png)  



* `Entities` là khái niệm dùng để mô tả các Business Logic. Đây là layer quan trọng nhất, là nơi bạn thực hiện giải quyết các vấn đề - mục đích khi xây dựng app. Layer này không chứa bất kỳ một framework nào, bạn có thể chạy nó mà không cần emulator. Nó giúp bạn dễ dàng test, maintain và develop phần business logic.

* `Use case` chứa các rule liên quan trực tiếp tới ứng dụng cục bộ (application-specific business rules).

* `Interface Adapter` tập hợp các adapter phục vụ quá trình tương tác với các công nghệ.

* `Framework and Drivers` chứa các công cụ về cơ sở dữ liệu và các framework, thông thường bạn sẽ không phải lập trình nhiều ở tầng này. Tuy nhiên cần chắc chắn về mức ưu tiên sử dụng các công cụ này trong project.



##### 2.Cấu trúc pakage dự án:

###### Dựa vào kiến trúc trên ta sẽ có cấu trúc dự án như sau: 

[app](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication)

.......[data](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/data)

...............[api](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/data/api)

.......................[retrofit](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/data/api/retrofit)

...................................[entities](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/data/api/retrofit/entities)

.......................volley

...................................entities

...............[db](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/data/db)

......................[realm](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/data/db/realm)

...............................[entities](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/data/db/realm/entities)

......................room

...............................entities

...............[repository](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/data/repository)

.......[di](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/di)

.......[ui](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/ui)

.............[activity](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/ui/activity)

.............[adapter](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/ui/adapter)

.............[fragment](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/ui/fragment)

.............[viewModel](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/app/src/main/java/net/lab/myapplication/ui/viewModel)

[domain](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/domain/src/main/java/net/lab/domain)

........[entities](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/domain/src/main/java/net/lab/domain/entities)

........[interact](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/domain/src/main/java/net/lab/domain/interact)

........[repository](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/tree/master/domain/src/main/java/net/lab/domain/repository)


###### Trong đó:

* `app`: xử lý giao diện và các phần liên quan đến api và db, FrameWork

* `data`: chuyên xử lý các vấn đề liên quan đến api và db

* `db`: sử lý vấn đề api về db

* `api`: xử lý vấn đề api về api

* `repository`: xử lý các nghiệp vụ thuần

* `di`: Khởi tạo dự án

* `ui`: liên quan đến giao diện

* `domain`: chuyển xử lý nghiệp vụ dự án, module này thuần java

* `entities`: các thực thế của dự án

* `interact`: xử lý các nghiệp vụ về dự án

* `repository`: định nghĩa các phương thức hỗ trợ interacto


###### Pakage với kiến trúc Clean Architecture

![Drag Racing](https://github.com/hoanganhtuan95ptit/MVVM-CleanArchitectureExample/blob/master/image/cleanArchitecture3.jpeg)

* `Entities`

-- domain/entities

* `Use case`

-- domain/interact
 
-- domain/repository

* `Interface Adapter`

-- domain/repository

-- app/data/repository

-- app/ui/viewModel

* `Framework and Drivers`

-- app/data/db

-- app/data/api

-- app/ui/activity

-- app/ui/adapter

-- app/ui/viewModel


###### Pakage với kiến trúc MVVM

* `View`

-- app/ui/activity

-- app/ui/adapter

-- app/ui/viewModel

* `Model`


-- app/data/db

-- app/data/api

-- app/data/repository

-- domain/entities

-- domain/interact
 
-- domain/repository

* `ViewModel`

-- app/ui/viewModel



##### 3.Cảm ơn

[Anthony Liberatore](https://medium.com/@ajliberatore/android-clean-architecture-mvvm-4df18933fa9)


