import { toast } from "react-toastify";

const defaultConfig = {
  position: "top-right",
  autoClose: 3000,
  hideProgressBar: false,
  closeOnClick: true,
  pauseOnHover: true,
  draggable: true,
  progress: undefined,
  theme: "light",
};

export const info = (message, ...props) => {
  toast.info(message, {
    ...defaultConfig,
    ...props,
  });
};

export const success = (message, ...props) => {
  toast.success(message, {
    ...defaultConfig,
    ...props,
  });
};

export const warning = (message, ...props) => {
  toast.warn(message, {
    ...defaultConfig,
    ...props,
  });
};

export const error = (message, ...props) => {
  toast.error(message, {
    ...defaultConfig,
    ...props,
  });
};
export const clear = () => {
  toast.dismiss();
};

export const custom = (payload, ...props) => {};
