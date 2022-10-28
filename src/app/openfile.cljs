(ns app.openfile
  (:require ["@tauri-apps/api/fs" :as fs]
            [taoensso.timbre :refer [debug info error fatal]]))


;; (defn read-text-file [path]
  ;; (-> (.readTextFile fs path)
      
