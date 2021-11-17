package com.pb.khyl.hw8;

public class Auth {
    private String login;
    private String password;

    public void signUp (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        if(login.length() < 5 || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть не меньше 5 и не больше 20 символов.");
        } else if (!login.matches("^[a-zA-Z0-9]+$")) {
            throw new WrongLoginException("Логин может содержать только латинские буквы и цифры.");
        } else {
            this.login = login;
        }

        if(password.length() < 5) {
            throw new WrongPasswordException("Длина пароля должна быть более 5 символов.");
        } else if (!password.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongPasswordException("Пароль может содержать только латинские буквы, цифры и знаки подчеркивания.");
        } else if (!password.matches(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
        } else {
            this.password = password;
            System.out.println("Регистрация успешна!");
        }
    }

    public void signIn (String login, String password) throws WrongLoginException {
        if(this.login != null || this.password != null) {
            if (!login.matches(this.login) || !password.matches(this.password)) {
                throw new WrongLoginException("Введены неверно логин или пароль");
            } else {
                System.out.println("Добро пожаловать!");
            }
        }
    }


}
