(ns app.events
  (:require [app.db :refer [default-db]]
            [re-frame.core :refer [reg-event-db reg-event-fx]]
            [taoensso.timbre :refer [debug]]))

(reg-event-db
 :init-db
 (fn [_ _]
   default-db))

(reg-event-db
 :busy?
 (fn [db [k v]]
   (assoc-in db [k] v)))