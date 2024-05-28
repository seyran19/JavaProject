### StudentOrder:
класс шаблон заявления студента;

### SaveStudentOrder:
в методе buildStudentOrder мы создаем новый шаблон, заполняем его данными, и возвращаем заполненное заявление.

### StudentOrderValidator:
класс служит для проверки студенческой заявки,
в конструкторе **_StudentOrderValidator_** создаем нове объекты:
- **childrenVal** = new CheckChildrenValidator() - метод **_checkChildren_** принимает заявление и проверяет детей;
- **studentVal** = new CheckStudentValidator() - метод **_checkStudent_** принимает заявление и проверяет студентов;
- **weddingVal** = new CheckWeddingValidator() - метод **_checkWedding_** принимает заявление и проверяет брак;
- **cityVal** = new CityRegisterValidator() - метод **_checkCityRegister_** принимает заявление и проверяет наличие в ГРН;
- **mailSender** = new MailSender() - метод **_sendMail_** принимает заявление и проверят отправлена ли почта;

Метод **_readStudentOrders_** возвращает список с заполненными заявлениями;

Метод **_checkCityRegister_** запускает и возвращает результат проверки **_cityVal.checkCityRegister(so)_**
, результатом проверки является класс **_AnswerCityRegister_**, у которого есть поле **_items_** которое содержит всю нашу семью;