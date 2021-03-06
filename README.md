[![GitHub release](https://img.shields.io/github/release/sismics/play-nuxeo.svg?style=flat-square)](https://github.com/sismics/play-nuxeo/releases/latest)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# play-nuxeo plugin

This plugin adds [Nuxeo](https://www.nuxeo.com/) support to Play! Framework 1 applications.

# Features

# How to use

####  Add the dependency to your `dependencies.yml` file

```
require:
    - nuxeo -> nuxeo 1.2.0

repositories:
    - sismicsNexusRaw:
        type: http
        artifact: "https://nexus.sismics.com/repository/sismics/[module]-[revision].zip"
        contains:
            - nuxeo -> *

```
####  Set configuration parameters

Add the following parameters to **application.conf**:

```
# Nuxeo configuration
# ~~~~~~~~~~~~~~~~~~~~
nuxeo.mock=false
nuxeo.url=https://nuxeo.example.com/nuxeo
nuxeo.username=Administrator
nuxeo.password=12345678
```
####  Use the client

```
Nuxeo.get().getNuxeoClient().repository().createDocument(...);
```

####  Mock the Nuxeo server in dev

We recommand to mock Nuxeo in development mode and test profile.

Use the following configuration parameter:

```
nuxeo.mock=true
```

# License

This software is released under the terms of the Apache License, Version 2.0. See `LICENSE` for more
information or see <https://opensource.org/licenses/Apache-2.0>.
