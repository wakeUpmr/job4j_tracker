package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class JobTest {
    @Test
    public void whenComparatorAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("adding smth", 2),
                new Job("adapt smth", 3),
                new Job("reboot server", 1),
        new Job("fix bugs", 4)
        );
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("adapt smth", 3),
                new Job("adding smth", 2),
                new Job("fix bugs", 4),
                new Job("reboot server", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("adding smth", 2),
                new Job("adapt smth", 3),
                new Job("reboot server", 1),
                new Job("fix bugs", 4)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("reboot server", 1),
                new Job("fix bugs", 4),
                new Job("adding smth", 2),
                new Job("adapt smth", 3)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("adding smth", 2),
                new Job("adapt smth", 3),
                new Job("reboot server", 1),
                new Job("fix bugs", 4)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("reboot server", 1),
                new Job("adding smth", 2),
                new Job("adapt smth", 3),
                new Job("fix bugs", 4)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
        public void whenComparatorPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("adding smth", 2),
                new Job("adapt smth", 3),
                new Job("reboot server", 1),
                new Job("fix bugs", 4)
        );
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("fix bugs", 4),
                new Job("adapt smth", 3),
                new Job("adding smth", 2),
                new Job("reboot server", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenCompatorDescByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 10),
                new Job("Impl task", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}