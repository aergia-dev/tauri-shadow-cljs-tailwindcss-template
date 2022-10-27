(ns app.views
  (:require [reagent.core :as r]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [app.subs]
            [app.toaster :as toaster]
            [taoensso.timbre :refer [debug info error fatal]]))


(defn default-view []
  )
