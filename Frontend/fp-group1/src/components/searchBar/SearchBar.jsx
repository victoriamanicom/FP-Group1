import "./SearchBar.css";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import FloatingLabel from "react-bootstrap/FloatingLabel";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useHistory } from "react-router-dom";

const SearchBar = ({
    handleSearch,
    handleReset,
    citizenForenames,
    setCitizenForenames,
    citizenSurname,
    setCitizenSurname,
    citizenGender,
    setCitizenGender,
}) => {
    const { push } = useHistory();
    return (
        <>
            <Form id="searchBarForm" onSubmit={(e) => handleSearch(e)}>
                <Row className="searchBarRow">
                    <Col>
                        <FloatingLabel
                            controlId="floatingForenames"
                            label="Forenames"
                        >
                            <Form.Control
                                type="text"
                                name="searchForenames"
                                placeholder="Forenames"
                                value={citizenForenames}
                                onChange={(e) =>
                                    setCitizenForenames(e.target.value)
                                }
                            />
                        </FloatingLabel>
                    </Col>
                    <Col>
                        <FloatingLabel
                            controlId="floatingSurname"
                            label="Surname"
                        >
                            <Form.Control
                                type="text"
                                name="searchSurname"
                                placeholder="Surname"
                                value={citizenSurname}
                                onChange={(e) =>
                                    setCitizenSurname(e.target.value)
                                }
                            />
                        </FloatingLabel>
                    </Col>
                    <Col>
                        <FloatingLabel
                            controlId="floatingGender"
                            label="Gender"
                        >
                            <Form.Select
                                name="searchGender"
                                value={citizenGender}
                                onChange={(e) =>
                                    setCitizenGender(e.target.value)
                                }
                            >
                                <option value=""></option>
                                <option value="Female">Female</option>
                                <option value="Male">Male</option>
                            </Form.Select>
                        </FloatingLabel>
                    </Col>
                    <Col xs={2} id="buttonColumn">
                        <Button
                            id="searchButton"
                            type="submit"
                            onClick={push(`/`)}
                        >
                            Search
                        </Button>
                        <br />
                        <Button
                            id="resetButton"
                            onClick={(e) => handleReset(e)}
                        >
                            Reset
                        </Button>
                    </Col>
                </Row>
            </Form>
        </>
    );
};

export default SearchBar;
