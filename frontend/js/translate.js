'use strict';

socialNetworkApp.config(function ($translateProvider) {
  $translateProvider.translations('en', {
    HOME_HEADER:"Home",
    FRIENDS_HEADER:"Friends",
    SEARCH_HEADER:"Search",
    EDIT_PROFILE_HEADER:"Edit prifile",
    CHANGE_PASSWORD_HEADER:"Change password",
    LOGOUT_HEADER:'Logout',
    TITLE: 'Hello',
    FOO: 'This is a message.',
    BUTTON_LANG_EN: 'eng',
    BUTTON_LANG_RU: 'russian',
    OLD_PASS:'Old password',
    NEW_PASS:'New password',
    CONF_PASS: 'Confirm Password',
    CHNG_PASS:'Change Password',
    CANCEL:"Cancel",
    DELETE:"Delete",
    EDIT:"Edit",
    SAVE:"Save",
    SHOW_ALL_COMMENTS:'Show All сomments :',
    EDIT_PROFILE:'Edit profile',
    NAME:'Name :',
    GENDER:"Gender :",
    LAST_NAME:'Last Name :',
    MALE:'Male',
    FEMALE:'Female',
    TOTAL:'total:',
    HOME:'Home:',
    FRIEND_REQUESTS:'Friend requests',
    APPROVE:'Approve',
    REJECT:'Reject',
    SEARCH:'Search',
    RESULT_TOTAL:'Result total',
    EDIT_PROFILE:'Edit profile',
    LOGOUT:'Logout',
    FRIEND:'Friend',
    FRIEND_REQUEST_PENDING:'Friend request pending',
    SEND_FRIEND_REQUEST:'Send friend request',
    LOGIN:'Login',
    USERNAME:'Username',
    PASSWORD:'Password',
    REGISTER:'Register',
    POST:'Post',
    BIRTHDAY_DATE:'Birthday date',
    CITY:'City :',
    STATE:'State :',
    COUNTRY:'Country :',
    EMAIL:'Email :',
    FRIENDS:'Friends',
    MY_PAGE:'My page',
    MY_FRIENDS:'My friends',
    MY_MESSAGES:'My messages',
    GROUPS:'Groups:',
    MY_EVENTS_NEWS:'My events/news',
    SETTINGS:'Settings',
    SELECT_LANGUAGE:'Select language:',
    DIALOG_TOTAL:"Dialog total",
    MESSAGES_TOTAL:"Messages total",
    GROUP_TOTAL:"Groups total",
    ADD_MESSAGE:"Add message",
    DIALOGS:"Dialogs:",
    ADD_DIALOG:"Add dialog",
    ADD_DIALOG1:"Add dialog:",
    TITLE:"Title:",
    DIALOG_TOTAL:"Dialogs total:",
    COMMENTS:"Comments:",
    COMMENT:"Comment",
    СOMMENTS_COUNT:"Comments count:",
    DIALOGS_MESSAGES:"Dialogs messages",
    DIALOGS_MESSAGES_TOTAL:"Dialogs messages total",
    ADD_DIALOG_MESSAGE:"Add Dialog message:",
    WRITE_DIALOG_MESSAGE:"Write dialog message",
    DATE_CREATION:"Date creation:",
    WRITED:"writed:",
    ABOUT:"About:",
    CHAT:"Chat",
    WRITE_COMMENT_PLACEHOLDER:"Write comment.......",
    WRITE_DIALOG_MESSAGE_PLACEHOLDER:"Write dialog message.......",
    WRITE_DIALOG_PLACEHOLDER:"Write dialog text...",
    WRITE_MESSAGE_PLACEHOLDER:"Write message....",
    WRITE_POST_PLACEHOLDER:"Write something....",
    SEARCH_PLACEHOLDER:"Search...",
    EVENTS_NEWS:"Events/News",
    SUBSCRIBE:"Subscribe",
    UNSUBSCRIBE:"Unsubscribe",
    SEND_PRIVATE_MESSAGE:"Send private message",
    MESSAGES:"Messages",
    RESULTS_TOTAL:"Results total:",
    DESCRIPTION:"Description:",
    WRITED_TO:"writed to:",
    FOLLOWERS:"Followers",
    FOLLOWINGS:"Followings",
    PRIVATE_MESSAGES:"Private messages",
    TOTAL_POST:"Total post:",
    AUTHOR:"Author:"

}),
  $translateProvider.translations('ru', {
    HOME_HEADER:"Дом",
    FRIENDS_HEADER:"Друзья",
    SEARCH_HEADER:"Поиск",
    EDIT_PROFILE_HEADER:"Профиль",
    CHANGE_PASSWORD_HEADER:"Сменить пароль",
    LOGOUT_HEADER:'Выйти',
    TITLE: 'Привет',
    FOO: '"Это сообщение.',
    BUTTON_LANG_EN: 'англ',
    BUTTON_LANG_RU: 'рус',
    OLD_PASS:'Cтарый пароль',
    NEW_PASS:'Новый пароль',
    CONF_PASS: 'Подтвердить пароль',
    CANCEL:"Отмена",
    DELETE:"Удалить",
    EDIT:"Редактировать",
    SAVE:"Сохранить",
    CHNG_PASS:'Сменить пароль',
    SHOW_ALL_COMMENTS:'Показать все комментарии :',
    COMMENT:'Комментировать',
    EDIT_PROFILE:'Редактировать профиль',
    NAME:'Имя :',
    LAST_NAME:'Фамилия :',
    GENDER:"Пол :",
    MALE:'Мужской',
    FEMALE:'Женский',
    TOTAL:'всего :',
    HOME:'Главная страница',
    FRIEND_REQUESTS:'Запросы в друзья',
    APPROVE:'Подтвердить',
    REJECT:'Отменить',
    SEARCH:'Поиск',
    RESULT_TOTAL:'Всего результатов',
    EDIT_PROFILE:'Редактировать профиль',
    LOGOUT:'Выйти',
    FRIEND:'Друг',
    FRIEND_REQUEST_PENDING:'Запрос в друзья',
    SEND_FRIEND_REQUEST:'Добавить в друзья',
    LOGIN:'Логирование',
    USERNAME:'Логин',
    PASSWORD:'Пароль',
    REGISTER:'Регистрация',
    POST:'Публикация',
    BIRTHDAY_DATE:'Дата рождения',
    CITY:'Город :',
    STATE:'Область :',
    COUNTRY:'Страна :',
    EMAIL:'Электронный адресс :',
    FRIENDS:'Друзья',
    MY_PAGE:'Моя страница',
    MY_FRIENDS:'Мои друзья',
    MY_MESSAGES:'Мои сообщения',
    GROUPS:'Группы:',
    MY_EVENTS_NEWS:'Мои события/новости',
    SETTINGS:'Настройки',
    SELECT_LANGUAGE:'Выберите язык:',
    DIALOG_TOTAL:"Всего диплогов",
    MESSAGES_TOTAL:"Всего сообщений",
    GROUP_TOTAL:"Всего групп",
    ADD_MESSAGE:"Добавить сообщение",
    DIALOGS:"Диалоги:",
    ADD_DIALOG:"Добавить диалог",
    ADD_DIALOG1:"Добавить диалог:",
    TITLE:"Заглавие:",
    DIALOG_TOTAL:"Всего диплогов:",
    COMMENTS:"Комментарии:",
    COMMENT:"Комментарий",
    СOMMENTS_COUNT:"Всего комментариев:",
    DIALOGS_MESSAGES:"Сообщения диалогов",
    DIALOGS_MESSAGES_TOTAL:"Всего сообщений в диалоге:",
    ADD_DIALOG_MESSAGE:"Добавить сообещие в диалог:",
    WRITE_DIALOG_MESSAGE:"Написать сообщение в диалог",
    DATE_CREATION:"Дата создания:",
    WRITED:"написал:",
    ABOUT:"Тема:",
    CHAT:"Переписка",
    WRITE_COMMENT_PLACEHOLDER:"Введите комментарий.......",
    WRITE_DIALOG_MESSAGE_PLACEHOLDER:"Введите сообение.......",
    WRITE_DIALOG_PLACEHOLDER:"Текст диалога...",
    WRITE_MESSAGE_PLACEHOLDER:"Введите сообещние....",
    WRITE_POST_PLACEHOLDER:"Введите что нибудь....",
    SEARCH_PLACEHOLDER:"Поиск...",
    EVENTS_NEWS:"События/Новости",
    SUBSCRIBE:"Подписаться",
    UNSUBSCRIBE:"Отписаться",
    SEND_PRIVATE_MESSAGE:"Написать личное сообщение",
    MESSAGES:"Сообщения",
    RESULTS_TOTAL:"Всего результатов:",
    DESCRIPTION:"Содержание:",
    WRITED_TO:"написал :",
    FOLLOWERS:"Мои подписки",
    FOLLOWINGS:"Подписчики",
    PRIVATE_MESSAGES:"Личные сообщения",
    TOTAL_POST:"Вcего записей:",
    AUTHOR:"Автор:"

});

  $translateProvider.useSanitizeValueStrategy(null);
  $translateProvider.preferredLanguage('en');
});


socialNetworkApp.controller('TransleteController', function TransleteController($scope, $translate) {
  $scope.changeLanguage = function (key) {
    $translate.use(key);
};
});