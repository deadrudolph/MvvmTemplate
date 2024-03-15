#!/bin/bash
git config core.hooksPath .git/hooks
cp script/git/pre-push .git/hooks/pre-push
