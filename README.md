


[phantomjs]: http://phantomjs.org/download.html
[maven]: http://maven.apache.org/
[git]: http://git-scm.com/

## Тестовое задание Java

### Дано
Дан файл вида: 
data file
operand1;operand2;operation;result
operand1;operand2;operation;result
operand1;operand2;operation;result
operand1;operand2;operation;result

каждая строка описывает арифметическое действие. 
·         operand1 и operand2 - операнды, целые числа
·         operation - арифметическое действие + - / *
·         result - результат операции operation над operand1 и operand2
В файле могут содержаться любые значения полей

### Требуется

·         Реализовать юнит (JUnit) тесты арифметических действий.

·         Каждое действие должно выглядеть в отчете как отдельный тестовый сценарий

·         Результатом выполнения должен быть Yandex.Allure отчет

·         Операнды, операция и результат должны быть представлены в отчете как параметры теста

·         Проект должен быть оформлен как артефакт Maven

·         Исходный код проекта должен быть выложен на github или bitbucket