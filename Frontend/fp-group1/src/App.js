import "./App.css";
import Navbar from "react-bootstrap/NavBar";
import "material-icons/iconfont/material-icons.css";
import SearchBar from "./components/searchBar/SearchBar";

function App() {
  return (
    <div className="App">
      <Navbar className="navbarHeader" fixed="sticky" variant="dark">
        <Navbar.Brand href="">
          <span class="material-icons">privacy_tip</span>
          National Investigation Unit
        </Navbar.Brand>
      </Navbar>
      <SearchBar />
    </div>
  );
}

export default App;
