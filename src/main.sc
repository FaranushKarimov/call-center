require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /BankTheme

    state: Start
        q!: $regex</start>
        a: Добрый день, Вы позвонили в call-center Dushanbe City, чем могу Вам помочь? || tts = "Добрый день,# Вы позвонили в call-center Dushanbe City,# чем могу Вам помочь?"
        buttons:
            "Выдача кредита" -> /Предоставьте пожалуйста документы, подтверждающие вашу личность.
        intent: /Документы для оформления кредита || toState = "/Предоставьте пожалуйста документы, подтверждающие вашу личность."
        event: noMatch || toState = "./"

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

    state: KnowledgeBase
        intentGroup!: /KnowledgeBase
        a: Нашёл ответ в базе знаний!
        script: $f
            
    state: NoMatch
        event!: noMatch
        a: Прошу прощения, переформулируйте Ваш вопрос.

    state: Предоставьте пожалуйста документы, подтверждающие вашу личность. || sessionResult = "Документы", sessionResultColor = "#BC3737"
        a: Предоставьте пожалуйста документы, подтверждающие вашу личность.
        go!: /Другие вопросы

    state: Другие вопросы
        a: Ответ будет Вам отправлен через две недели. Есть ли еще у Вас вопросы?
        buttons:
            "Да, есть еще вопрос." -> /Start
            "Вопросов нет"
        intent: /Есть вопросы || toState = "/Start"
        event: noMatch || toState = "./"