(ns app.views
  (:require [re-frame.core :refer [subscribe dispatch]]
            [app.common.spin :refer [spinner]]
            [app.subs]
            ["react-toastify" :refer [ToastContainer]]
            [app.common.toaster :refer [toast]]
            [taoensso.timbre :refer [debug info error fatal]]))

(defn default-views []
  [:div
   [:> ToastContainer (clj->js {:position "bottom-right"
                                :autoClose 2000
                                :hideProgressBar false
                                :newestOnTop false
                                :closeOnClick true
                                :rtl false
                                :pauseOnFocusLoss false
                                :draggable true
                                :pauseOnHover true})]
   [:div {:class "flex h-screen w-screen items-center justify-center fixed z-999"}
    (let [enable? @(subscribe [:busy?])]
      (spinner "" enable?))]])

(defn views []
  [:div
   [default-views]])