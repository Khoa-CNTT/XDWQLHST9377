import { Box, Container, Grid } from "@mui/material";

import MainCard from "../../components/Card/MainCard";

export const AuthWrapper = ({ children }) => (
  <Box sx={{ minHeight: "100vh" }} xs={12}>
    <Grid item>
      <Grid
        item
        xs={12}
        container
        justifyContent="center"
        alignItems="center"
        sx={{
          minHeight: { xs: "calc(100vh - 134px)", md: "calc(100vh - 112px)" },
        }}
      >
        <Grid item justifyContent="center" display="flex">
          <MainCard
            sx={{
              maxWidth: { xs: 400, lg: 375 },
              margin: { xs: 3.5, md: 3 },
              "& > *": {
                flexGrow: 1,
                flexBasis: "50%",
              },
              position: "relative",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              overflow: "hidden",
              zIndex: 10,
              // backgroundColor: "transparent"
            }}
            boxShadow
            // border={false}
          >
            <Box sx={{ p: { xs: 2, sm: 3, md: 4, xl: 5 } }}>{children}</Box>
          </MainCard>
          <Container
            sx={{
              position: "absolute",
              // zIndex: 100,
              margin: { xs: 1.5, md: 1.5 },
              zIndex: 8,
              maxWidth: { xs: 340, lg: 325 },
              height: "30px",
              opacity: 0.25,
              backgroundColor: "white",
            }}
          />
          <Container
            sx={{
              position: "absolute",
              // zIndex: 100,
              zIndex: 6,
              maxWidth: { xs: 300, lg: 245 },
              height: "120px",
              opacity: 0.15,
              backgroundColor: "white",
            }}
          />
        </Grid>
      </Grid>
    </Grid>
  </Box>
);

// const MainCard = forwardRef(
//     (
//         {
//             border = true,
//             boxShadow,
//             children,
//             content = true,
//             contentSX = {},
//             darkTitle,
//             elevation,
//             secondary,
//             shadow,
//             sx = {},
//             title,
//             codeHighlight,
//             ...others
//         },
//         ref
//     ) => {
//         return (
//             <Card
//                 elevation={elevation || 0}
//                 ref={ref}
//                 {...others}
//                 sx={{
//                     border: border ? '1px solid' : 'none',
//                     borderRadius: 2,
//                     borderColor: colors.grey[100],
//                     boxShadow: boxShadow && (!border) ? `0px 2px 8px ${alpha(colors.grey[300], 0.15)}` : 'inherit',
//                     ':hover': {
//                         boxShadow: boxShadow ? `0px 2px 8px ${alpha(colors.grey[300], 0.5)}` : 'inherit'
//                     },

//                     '& pre': {
//                         m: 0,
//                         p: '16px !important',
//                         // fontFamily: theme.typography.fontFamily,
//                         fontSize: '0.75rem'
//                     },
//                     ...sx
//                 }}
//             >
//                 {children}
//             </Card>
//         );
//     }
// );
// AuthWrapper.propTypes = {
//     children: PropTypes.node
// };

// export default AuthWrapper;
