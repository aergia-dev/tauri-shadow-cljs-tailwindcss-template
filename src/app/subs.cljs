(ns app.subs
  (:require [re-frame.core :refer [reg-sub subscribe]]
            [taoensso.timbre :refer [debug info error fatal]]))


(reg-sub
 :busy?
 (fn [db _]
   (:busy? db)))