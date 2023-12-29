import React from 'react';
import { useLocation } from 'react-router-dom';

function Shelter() {
    const location = useLocation();
    const shelterInfo = new URLSearchParams(location.search);
    const shelterName = shelterInfo.get("name");

    return (
        <div>
            Shelter {shelterName}
        </div>
    );
}

export default Shelter;