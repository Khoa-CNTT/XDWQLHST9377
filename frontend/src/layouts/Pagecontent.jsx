import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import PropTypes from "prop-types";
import Overview from "./page/Overview";
import ManageAccounts from "./page/Accounts";
import ManageTeachers from "./page/Teachers";
import ManageStudents from "./page/Students";
import ManageParents from "./page/Parents";

const pageComponents = {
  "/toolpad/core/introduction": Overview,
  "/dashboard": Overview,
  "/overview": Overview,
  "/manage/accounts": ManageAccounts,
  "/manage/teachers": ManageTeachers,
  "/manage/students": ManageStudents,
  "/manage/parents": ManageParents,
};

function PageContent({ pathname }) {
  const Component =
    pageComponents[pathname] || (() => <Typography>Page Not Found</Typography>);
  return (
    <Box
      sx={{
        py: 4,
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        textAlign: "center",
      }}
    >
      <Component />
      {/* <Typography>{pathname}</Typography> */}
    </Box>
  );
}

PageContent.propTypes = {
  pathname: PropTypes.string.isRequired,
};

export default PageContent;
