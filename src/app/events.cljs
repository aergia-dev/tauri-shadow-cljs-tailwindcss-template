(ns app.events
  (:require [re-frame.core :refer [reg-event-db reg-event-fx]]
            [app.db :refer [default-db]]
            [taoensso.timbre :refer [debug info error fatal]]))

(reg-event-db
 :init-db
 (fn [_ _]
   (let [db (merge {} default-db)]
     db)))

(reg-event-db
 :files
 (fn [db files]
   (js/console.log "files: " (js->clj (.-FileName files)))
   db))
