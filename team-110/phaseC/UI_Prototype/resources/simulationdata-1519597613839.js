function initData() {
  jimData.variables["incr"] = "1";
  jimData.variables["empty cell"] = "";
  jimData.variables["time"] = "20";
  jimData.variables["Git Repo"] = "";
  jimData.datamasters["git_modified2"] = [
    {
      "id": 1,
      "datamaster": "git_modified2",
      "userdata": {
        "GIT REPOSITORIES": "sample text"
      }
    },
    {
      "id": 2,
      "datamaster": "git_modified2",
      "userdata": {
        "GIT REPOSITORIES": "sample text"
      }
    },
    {
      "id": 3,
      "datamaster": "git_modified2",
      "userdata": {
        "GIT REPOSITORIES": "sample text"
      }
    },
    {
      "id": 4,
      "datamaster": "git_modified2",
      "userdata": {
        "GIT REPOSITORIES": "sample text"
      }
    },
    {
      "id": 5,
      "datamaster": "git_modified2",
      "userdata": {
        "GIT REPOSITORIES": "sample text"
      }
    },
    {
      "id": 6,
      "datamaster": "git_modified2",
      "userdata": {
        "GIT REPOSITORIES": "sample text"
      }
    }
  ];

  jimData.datamasters["git_repositories"] = [
    {
      "id": 1,
      "datamaster": "git_repositories",
      "userdata": {
        "GIT REPOSITORIES": "CS5500/student-158/hmk1"
      }
    },
    {
      "id": 2,
      "datamaster": "git_repositories",
      "userdata": {
        "GIT REPOSITORIES": "CS5500/student-160/hmk1"
      }
    },
    {
      "id": 3,
      "datamaster": "git_repositories",
      "userdata": {
        "GIT REPOSITORIES": "CS5500/student-163/hmk1"
      }
    },
    {
      "id": 4,
      "datamaster": "git_repositories",
      "userdata": {
        "GIT REPOSITORIES": "CS5500/student-158/hmk2"
      }
    },
    {
      "id": 5,
      "datamaster": "git_repositories",
      "userdata": {
        "GIT REPOSITORIES": "CS5500/student-160/hmk2"
      }
    },
    {
      "id": 6,
      "datamaster": "git_repositories",
      "userdata": {
        "GIT REPOSITORIES": "CS5500/student-163/hmk2"
      }
    }
  ];
  jimData.datamasters["git_repositories"].category = {
    "GIT REPOSITORIES": ["CS5500/student-158/hmk1","CS5500/student-160/hmk1","CS5500/student-163/hmk1","CS5500/student-158/hmk2","CS5500/student-160/hmk2","CS5500/student-163/hmk2"]
  };

  jimData.datamasters["git_repo_modified3"] = [
    {
      "id": 1,
      "datamaster": "git_repo_modified3",
      "userdata": {
        "GIT REPOSITORIES": "CS5500"
      }
    }
  ];

  jimData.datamasters["Git Repo"] = [
    {
      "id": 1,
      "datamaster": "Git Repo",
      "userdata": {
        "CS5500/student-158/hmk1": "sample text",
        "CS5500/student-160/hmk1": "sample text",
        "CS5500/student-163/hmk1": "sample text",
        "CS5500/student-158/hmk2": "sample text",
        "CS5500/student-160/hmk2": "sample text",
        "CS5500/student-163/hmk2": "sample text"
      }
    },
    {
      "id": 2,
      "datamaster": "Git Repo",
      "userdata": {
        "CS5500/student-158/hmk1": "sample text",
        "CS5500/student-160/hmk1": "sample text",
        "CS5500/student-163/hmk1": "sample text",
        "CS5500/student-158/hmk2": "sample text",
        "CS5500/student-160/hmk2": "sample text",
        "CS5500/student-163/hmk2": "sample text"
      }
    },
    {
      "id": 3,
      "datamaster": "Git Repo",
      "userdata": {
        "CS5500/student-158/hmk1": "sample text",
        "CS5500/student-160/hmk1": "sample text",
        "CS5500/student-163/hmk1": "sample text",
        "CS5500/student-158/hmk2": "sample text",
        "CS5500/student-160/hmk2": "sample text",
        "CS5500/student-163/hmk2": "sample text"
      }
    },
    {
      "id": 4,
      "datamaster": "Git Repo",
      "userdata": {
        "CS5500/student-158/hmk1": "sample text",
        "CS5500/student-160/hmk1": "sample text",
        "CS5500/student-163/hmk1": "sample text",
        "CS5500/student-158/hmk2": "sample text",
        "CS5500/student-160/hmk2": "sample text",
        "CS5500/student-163/hmk2": "sample text"
      }
    },
    {
      "id": 5,
      "datamaster": "Git Repo",
      "userdata": {
        "CS5500/student-158/hmk1": "sample text",
        "CS5500/student-160/hmk1": "sample text",
        "CS5500/student-163/hmk1": "sample text",
        "CS5500/student-158/hmk2": "sample text",
        "CS5500/student-160/hmk2": "sample text",
        "CS5500/student-163/hmk2": "sample text"
      }
    },
    {
      "id": 6,
      "datamaster": "Git Repo",
      "userdata": {
        "CS5500/student-158/hmk1": "sample text",
        "CS5500/student-160/hmk1": "sample text",
        "CS5500/student-163/hmk1": "sample text",
        "CS5500/student-158/hmk2": "sample text",
        "CS5500/student-160/hmk2": "sample text",
        "CS5500/student-163/hmk2": "sample text"
      }
    }
  ];

  jimData.isInitialized = true;
}