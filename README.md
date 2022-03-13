# POS in Shell

通过本次作业对分层系统的理解：

通过将购物系统分离出

- 操作层（对用户命令进行响应）
- 定义层（定义数据的类型和操作方法）
- 服务层（提供服务函数接口以供调用）
- 数据层（通过数据库存储数据并提供相应操作接口）

将原本功能多样复杂的命令行购物程序分成数个更简单的层级，只需要实现每个层级对应的方法、只调用下一层级的方法，即可将复杂的功能拆解为下一层级的一两个新函数，每个函数又依次向下对应或已存在或需编写的函数。层级架构分明，便于增删修改。

The demo shows a simple POS system with command line interface. Currently it implements three commands which you can see using the `help` command.

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.7)
 
shell:>help
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Pos Command
        a: Add a Product to Cart
        n: New Cart
        p: List Products
```

Everytime a customer come to make a purchase, use `n` to create a new cart and then use `a ${productid} ${amount}` to add a product to the cart.

Please make the POS system robust and fully functional by implementing more commands, for instance, print/empty/modify cart.

Implementing a PosDB with real database is very much welcome. 

