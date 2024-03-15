#!/bin/bash
BRANCH_NAME_THRESHOLD=100
PROTECTED_BRANCHES="^(master|development|release)$"
BRANCH_REGEX="(^(bugfix|feature)\/[a-zA-Z0-9]([A-Za-z0-9\-_\/])*)"

branch_name="$(git rev-parse --abbrev-ref HEAD)"
branch_name_length=${#branch_name}

if [[ branch_name_length -gt BRANCH_NAME_THRESHOLD ]]; then
  echo "Too long branch name. Current length is $branch_name_length but expected lower than threshold $BRANCH_NAME_THRESHOLD."
  exit 1
fi

if [[ $branch_name =~ $PROTECTED_BRANCHES || $branch_name =~ $BRANCH_REGEX ]];
then
    ./gradlew detektAll; lint_return_code=$?
    exit $lint_return_code
else
    echo "Branch name doesn't matches by branch pattern: $BRANCH_REGEX."
    exit 1
fi
