package ru.innopolis.site.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.innopolis.site.dto.AccountDto;
import ru.innopolis.site.models.Account;
import ru.innopolis.site.repositories.AccountsRepository;

import java.util.List;

import static ru.innopolis.site.dto.AccountDto.from;


@Service
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    public AccountsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        return from(accountsRepository.findAll());
    }

    @Override
    public void ban(Long userId) {
        Account account = accountsRepository.getById(userId);
        account.setState(Account.State.BANNED);
        accountsRepository.save(account);
    }

    @Override
    public List<AccountDto> getUsers(int page, int size) {
        PageRequest request = PageRequest.of(page,size);
        Page<Account> accountPage = accountsRepository.findAll(request);
        return from(accountPage.getContent());
    }
}
