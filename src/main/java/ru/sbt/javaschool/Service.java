package ru.sbt.javaschool;

import java.util.List;

public interface Service {
    @Cache(cacheType = CacheType.FILE, identityBy = {String.class, int.class})
    double doHardWork(final String work, final int value);

    @Cache(cacheType = CacheType.MEMORY, fileNamePrefix = "myPrefix.zip", zip = true, listLength = 2)
    List<Double> run(final String item);
}
