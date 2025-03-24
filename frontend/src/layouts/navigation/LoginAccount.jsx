import * as React from "react";

export const useSession = () => {
  const [session, setSession] = React.useState({
    user: {
      name: "Harry Nguyen",
      email: "",
      image: "./src/assets/imgs/avatar.jpg",
    },
  });

  const authentication = React.useMemo(() => {
    return {
      signIn: () => {
        setSession({
          user: {
            name: "Harry Nguyen",
            email: "",
            image: "./src/assets/imgs/avatar.jpg",
          },
        });
      },
      signOut: () => {
        setSession(null);
      },
    };
  }, []);

  return { session, authentication };
};
