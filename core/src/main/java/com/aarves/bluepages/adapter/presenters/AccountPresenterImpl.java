package com.aarves.bluepages.adapter.presenters;

import com.aarves.bluepages.usecase.interactors.AccountPresenter;
import com.aarves.bluepages.usecase.interactors.LoginResult;

public class AccountPresenterImpl implements AccountPresenter {
    private AccountView accountView;

    public void setAccountView(AccountView accountView) {
        this.accountView = accountView;
    }

    @Override
    public void loginResult(LoginResult result, String username) {
        if(this.verifyDependencies()) {
            String message;
            switch (result) {
                case SUCCESS:
                    message = "Welcome back " + username + "!";
                    this.accountView.startMainMenu();
                    this.accountView.finishActivity();
                    break;
                case FAILURE:
                    message = "Incorrect password!";
                    break;
                case ACCOUNT_NOT_FOUND:
                    message = "Incorrect username!";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + result);
            }
            this.accountView.displayPopUp(message);
        }
    }

    @Override
    public void registerResult(boolean result) {
        if(this.verifyDependencies()) {
            String message;
            if (result) {
                message = "Account created successfully.";
                this.accountView.finishActivity();
            } else {
                message = "Passwords do not match!";
            }
            this.accountView.displayPopUp(message);
        }
    }

    private boolean verifyDependencies() {
        return this.accountView != null;
    }
}
