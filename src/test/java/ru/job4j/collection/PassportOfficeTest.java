package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddADuplicatePassport() {
        Citizen firstCitizen = new Citizen("4d11a", "Egor Krivonos");
        Citizen secondCitizen = new Citizen("4d11a", "Yakov Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(firstCitizen);
        assertThat(office.add(secondCitizen)).isFalse();
    }
}