(ns app.common.toaster
  (:require ["react-toastify" :as rt]))

(defn toast [msg]
  (.success rt/toast msg (clj->js {:position "bottom-right"
                                   :autoClose 200
                                   :hideProgressBar false
                                   :closeOnClick true
                                   :pauseOnHover true
                                   :draggable true
                                   :progress nil})))