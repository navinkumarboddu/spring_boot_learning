package com.pluralsight.fundamentals.service;

import com.pluralsight.fundamentals.entity.Release;

public interface ReleaseService {
    Iterable<Release> listReleases();
}

