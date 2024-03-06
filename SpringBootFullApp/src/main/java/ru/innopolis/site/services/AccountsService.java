package ru.innopolis.site.services;

import ru.innopolis.site.dto.AccountDto;

import java.util.List;


public interface AccountsService {

    List<AccountDto> getAll();

    void ban(Long userId);

    List<AccountDto> getUsers(int page, int size);
}
