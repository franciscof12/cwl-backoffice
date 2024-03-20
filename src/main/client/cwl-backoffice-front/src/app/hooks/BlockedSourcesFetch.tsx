import { useState, useEffect } from 'react';
import {BlockedSources} from "@/app/promises/interfaces";

const useBlockedSources = (url: string): [BlockedSources[], () => void] => {
    const [data, setData] = useState<BlockedSources[]>([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(url);
                const jsonData: BlockedSources[] = await response.json();
                setData(jsonData);
            } catch (error) {
                console.error('Error fetching data:', error);
                setData([]);
            }
        };

        fetchData();
    }, [url]);

    const refreshData = async () => {
        try {
            const response = await fetch(url);
            const jsonData: BlockedSources[] = await response.json();
            setData(jsonData);
        } catch (error) {
            console.error('Error fetching data:', error);
            setData([]);
        }
    };

    return [data, refreshData];
};

export default useBlockedSources;
