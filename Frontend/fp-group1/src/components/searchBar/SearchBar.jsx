

const SearchBar = ({handleSearch}) => {

    const handleReset = e => {
        e.preventDefault();
        e.target.reset();
    }

    return (
        <>
            <form id="searchBarForm" onSubmit={handleSearch}>
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <label>Forenames</label>
                            <label>Surname</label>
                            <label class="container">Female
                                <input type="checkbox"/>
                                <span class="checkmark"></span>
                            </label>
                            <button type="submit">Search</button>
                        </div>
                        <div class="col">
                            <input type="text" name="searchForenames"/>
                            <input type="text" name="searchSurname"/>
                            <label class="container">Male
                                <input type="checkbox"/>
                                <span class="checkmark"></span>
                            </label>
                            <button onClick={handleReset}>Reset</button>
                        </div>
                    </div>
                </div>
            </form>
        </>
    )

}

export default SearchBar;