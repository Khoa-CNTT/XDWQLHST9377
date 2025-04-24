const _PREFIX = "SB.";

const _getFullKey = (key, noPrefix = false) => {
  if (noPrefix) {
    return key;
  }

  return _PREFIX + key;
};

export const removeLocalData = (key, noPrefix = false) => {
  const realKey = _getFullKey(key, noPrefix);

  return window.localStorage.removeItem(realKey);
};

export const getLocalData = (key, defaultValue = null, noPrefix = false) => {
  const realKey = _getFullKey(key, noPrefix);

  const value = window.localStorage.getItem(realKey) || defaultValue;

  try {
    return JSON.parse(value);
  } catch (e) {
    return value;
  }
};

export const setLocalData = (key, value, noPrefix = false) => {
  const realKey = _getFullKey(key, noPrefix);

  const type = typeof value;
  if (type === "object") {
    value = JSON.stringify(value);
  }

  window.localStorage.setItem(realKey, value);

  return value;
};
