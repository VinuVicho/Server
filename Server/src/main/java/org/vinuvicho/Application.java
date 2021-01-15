package org.vinuvicho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "org.vinuvicho")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}



//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class Application {
//    public static void main(final String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//}

/*
add to cart/remove from/get cart
==============================
unit test
int test
=======
will be done :
simulate DB
logic
як закинути на git:
0. git clone повна_урла_до_репозиторію
1. git init
2. додаєте .gitignore файл
3. git status - покаже статус файлів проекту
4. git add .
5. git commit -m "назва коміту"
3. VCS -> Import into Version Control -> Share project on Github
--master бренча--
git checkout -b назва_нової_бренчі
git add .
git commit -m "назва коміту"
git push origin назва_нової_бренчі
git log - показує останні коміти (вихід q)
git pull - завантажує всі зміни з бренчі на якій ви знаходитеся
git reset . - зворотня команда до git add
git merge назва_бренчі - змерджить "назва_бренчі" у вашу теперішню бренчу
master -> git checkout -b назва_першої_бренчі -> мерджите через ПР в мастер  ->
-> переходите в мастер -> git pull -> git checkout -b назва_другої_бренчі  ->
-> мерджите через ПР в мастер
resource/controller - повинен бути простим
service - містить бізнес-логіку
repository - містить спосіб отримання даних
entity - працює ЛИШЕ з репозиторієм, серсісом та маппером
mapper - робить конвертацію між entity та dto
dto/model - працює ЛИШЕ з контроллер/ресурс, серсісом та маппером
exception - містить вийняткові ситуації та обробник
KISS - залиш це простим
DRY - не повторюй себе
YAGNI - тобі це не потрібно
200 - все ок
300 - редірект
400 - помилка клієнта
500 - помилка сервера
Підготувати:
1. валідація
2. Закінчити з репозиторіями для book та order
*/