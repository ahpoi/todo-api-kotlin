#!/usr/bin/env bash

branch=$(git symbolic-ref HEAD | sed -e 's,.*/\(.*\),\1,')

# v1.0.0, v1.5.2, etc.
versionLabel=v$1

# establish branch and tag name variables
masterBranch=master
releaseBranch=release-$versionLabel

# create the release branch from the -develop branch
git checkout -b $releaseBranch $masterBranch

# commit version number increment
git commit -am "Incrementing version number to $versionLabel"

# create tag for new version from -master
git tag $versionLabel

# merge release branch with the new version number back into develop
git checkout $masterBranch
git merge --no-ff $releaseBranch

# remove release branch
git branch -d $releaseBranch