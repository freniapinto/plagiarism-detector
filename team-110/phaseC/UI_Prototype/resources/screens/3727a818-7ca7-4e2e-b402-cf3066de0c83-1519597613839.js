jQuery("#simulation")
  .on("click", ".s-3727a818-7ca7-4e2e-b402-cf3066de0c83 .click", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getEventFirer();
    if(jFirer.is("#s-Label_4")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/3727a818-7ca7-4e2e-b402-cf3066de0c83"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_5")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/40ff5095-5160-43a4-b917-2de13e9a0943"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_6")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/a4c26bf6-ddde-49c5-b9db-ad7745266b87"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Button_12")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": [ "#s-Panel_3" ]
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Button_3")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_3" ],
                    "value": {
                      "action": "jimAddToData",
                      "parameter": [ {
                        "datatype": "property",
                        "target": "#s-Category_3",
                        "property": "jimGetValue"
                      },{
                        "datatype": "property",
                        "target": "#s-Category_4",
                        "property": "jimGetSelectedValue"
                      } ]
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                },
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_4" ],
                    "value": {
                      "action": "jimRemoveFromData",
                      "parameter": [ {
                        "datatype": "property",
                        "target": "#s-Category_4",
                        "property": "jimGetValue"
                      },{
                        "datatype": "property",
                        "target": "#s-Category_4",
                        "property": "jimGetSelectedValue"
                      } ]
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Button_4")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_4" ],
                    "value": {
                      "action": "jimAddToData",
                      "parameter": [ {
                        "datatype": "property",
                        "target": "#s-Category_4",
                        "property": "jimGetValue"
                      },{
                        "datatype": "property",
                        "target": "#s-Category_3",
                        "property": "jimGetSelectedValue"
                      } ]
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                },
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_3" ],
                    "value": {
                      "action": "jimRemoveFromData",
                      "parameter": [ {
                        "datatype": "property",
                        "target": "#s-Category_3",
                        "property": "jimGetValue"
                      },{
                        "datatype": "property",
                        "target": "#s-Category_3",
                        "property": "jimGetSelectedValue"
                      } ]
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Button_13")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_3" ],
                    "value": {
                      "action": "jimAddToData",
                      "parameter": [ {
                        "datatype": "property",
                        "target": "#s-Category_4",
                        "property": "jimGetValue"
                      },{
                        "datatype": "property",
                        "target": "#s-Category_3",
                        "property": "jimGetValue"
                      } ]
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                },
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_4" ],
                    "value": {
                      "action": "jimRemoveFromData",
                      "parameter": [ {
                        "datatype": "property",
                        "target": "#s-Category_4",
                        "property": "jimGetValue"
                      },{
                        "datatype": "property",
                        "target": "#s-Category_4",
                        "property": "jimGetValue"
                      } ]
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Button_14")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_4" ],
                    "value": {
                      "action": "jimFilterData",
                      "parameter": {
                        "datatype": "datamaster",
                        "datamaster": "git_repositories",
                        "value": {
                          "datatype": "property",
                          "target": "#s-Input_6",
                          "property": "jimGetValue"
                        }
                      }
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Button_11")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_4" ],
                    "value": {
                      "action": "jimAddToData",
                      "parameter": [ {
                        "datatype": "property",
                        "target": "#s-Category_3",
                        "property": "jimGetValue"
                      },{
                        "datatype": "property",
                        "target": "#s-Category_4",
                        "property": "jimGetValue"
                      } ]
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                },
                {
                  "action": "jimSetValue",
                  "parameter": {
                    "target": [ "#s-Category_3" ],
                    "value": {
                      "action": "jimRemoveFromData",
                      "parameter": [ {
                        "datatype": "property",
                        "target": "#s-Category_3",
                        "property": "jimGetValue"
                      },{
                        "datatype": "property",
                        "target": "#s-Category_3",
                        "property": "jimGetValue"
                      } ]
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Button_15")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/37b3613f-ee8b-4e35-a290-ef03b58de91e",
                    "transition": "pop"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Button_16")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": [ "#s-Panel_2" ]
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_37")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/d12245cc-1680-458d-89dd-4f0d7fb22724",
                    "transition": "slidedown"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    }
  })
  .on("focusin", ".s-3727a818-7ca7-4e2e-b402-cf3066de0c83 .focusin", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getEventFirer();
    if(jFirer.is("#s-Input_5")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Input_5": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#0088CC",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#0088CC",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#0088CC",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#0088CC",
                        "border-radius": "5px 5px 5px 5px",
                        "padding-top": "3px",
                        "padding-right": "3px",
                        "padding-bottom": "3px",
                        "padding-left": "8px"
                      },
                      "expressions": {
                        "width": "Math.max(449 - 1 - 1 - 8 - 3, 0) + 'px'",
                        "height": "Math.max(48 - 1 - 1 - 3 - 3, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Input_6")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Input_6": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#0088CC",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#0088CC",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#0088CC",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#0088CC",
                        "border-radius": "3px 3px 3px 3px",
                        "padding-top": "2px",
                        "padding-right": "2px",
                        "padding-bottom": "2px",
                        "padding-left": "7px"
                      },
                      "expressions": {
                        "width": "Math.max(216 - 1 - 1 - 7 - 2, 0) + 'px'",
                        "height": "Math.max(31 - 1 - 1 - 2 - 2, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    }
  })
  .on("focusout", ".s-3727a818-7ca7-4e2e-b402-cf3066de0c83 .focusout", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getEventFirer();
    if(jFirer.is("#s-Input_5")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Input_5": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#CCCCCC",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#CCCCCC",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#CCCCCC",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#CCCCCC",
                        "border-radius": "5px 5px 5px 5px",
                        "padding-top": "3px",
                        "padding-right": "3px",
                        "padding-bottom": "3px",
                        "padding-left": "8px"
                      },
                      "expressions": {
                        "width": "Math.max(449 - 1 - 1 - 8 - 3, 0) + 'px'",
                        "height": "Math.max(48 - 1 - 1 - 3 - 3, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Input_6")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Input_6": {
                      "attributes": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#CCCCCC",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#CCCCCC",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#CCCCCC",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#CCCCCC",
                        "border-radius": "3px 3px 3px 3px",
                        "padding-top": "2px",
                        "padding-right": "2px",
                        "padding-bottom": "2px",
                        "padding-left": "7px"
                      },
                      "expressions": {
                        "width": "Math.max(216 - 1 - 1 - 7 - 2, 0) + 'px'",
                        "height": "Math.max(31 - 1 - 1 - 2 - 2, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    }
  })
  .on("mouseenter dragenter", ".s-3727a818-7ca7-4e2e-b402-cf3066de0c83 .mouseenter", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getDirectEventFirer(this);
    if(jFirer.is("#s-Label_5") && jFirer.has(event.relatedTarget).length === 0) {
      event.backupState = true;
      event.target = jFirer;
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_5": {
                      "attributes": {
                        "width": "jimEvent.fn.getCurrentStyle('width', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_5') + jimEvent.fn.getCurrentStyle('padding-left', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_5') + jimEvent.fn.getCurrentStyle('padding-right', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_5') - 14 - 0",
                        "height": "jimEvent.fn.getCurrentStyle('height', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_5') + jimEvent.fn.getCurrentStyle('padding-top', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_5') + jimEvent.fn.getCurrentStyle('padding-bottom', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_5') - 0 - 0",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "background-color": "#EEEEEE",
                        "background-image": "none",
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "11px 11px 11px 11px"
                      },
                      "expressions": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(126 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  },{
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_5": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "11px 11px 11px 11px",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "-pie-background": "#EEEEEE",
                        "-pie-poll": "false"
                      },
                      "expressions-ie": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(126 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_6") && jFirer.has(event.relatedTarget).length === 0) {
      event.backupState = true;
      event.target = jFirer;
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_6": {
                      "attributes": {
                        "width": "jimEvent.fn.getCurrentStyle('width', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_6') + jimEvent.fn.getCurrentStyle('padding-left', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_6') + jimEvent.fn.getCurrentStyle('padding-right', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_6') - 14 - 0",
                        "height": "jimEvent.fn.getCurrentStyle('height', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_6') + jimEvent.fn.getCurrentStyle('padding-top', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_6') + jimEvent.fn.getCurrentStyle('padding-bottom', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_6') - 0 - 0",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "background-color": "#EEEEEE",
                        "background-image": "none",
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "12px 12px 12px 12px"
                      },
                      "expressions": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(130 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  },{
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_6": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "12px 12px 12px 12px",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "-pie-background": "#EEEEEE",
                        "-pie-poll": "false"
                      },
                      "expressions-ie": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(130 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_7") && jFirer.has(event.relatedTarget).length === 0) {
      event.backupState = true;
      event.target = jFirer;
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_7": {
                      "attributes": {
                        "width": "jimEvent.fn.getCurrentStyle('width', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_7') + jimEvent.fn.getCurrentStyle('padding-left', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_7') + jimEvent.fn.getCurrentStyle('padding-right', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_7') - 14 - 0",
                        "height": "jimEvent.fn.getCurrentStyle('height', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_7') + jimEvent.fn.getCurrentStyle('padding-top', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_7') + jimEvent.fn.getCurrentStyle('padding-bottom', '#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_7') - 0 - 0",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "background-color": "#EEEEEE",
                        "background-image": "none",
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "12px 12px 12px 12px"
                      },
                      "expressions": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(130 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  },{
                    "#s-3727a818-7ca7-4e2e-b402-cf3066de0c83 #s-Label_7": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "12px 12px 12px 12px",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "-pie-background": "#EEEEEE",
                        "-pie-poll": "false"
                      },
                      "expressions-ie": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(130 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      jEvent.launchCases(cases);
    }
  })
  .on("mouseleave dragleave", ".s-3727a818-7ca7-4e2e-b402-cf3066de0c83 .mouseleave", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getDirectEventFirer(this);
    if(jFirer.is("#s-Label_5")) {
      jEvent.undoCases(jFirer);
    } else if(jFirer.is("#s-Label_6")) {
      jEvent.undoCases(jFirer);
    } else if(jFirer.is("#s-Label_7")) {
      jEvent.undoCases(jFirer);
    }
  });