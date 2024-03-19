import { useState, useEffect } from 'react';
import {SourcesContent} from "@/app/promises/interfaces";

const useFetchData = (url: string): SourcesContent[] => {
    const [data, setData] = useState<SourcesContent[]>([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(url);
                const jsonData: SourcesContent[] = await response.json();
                setData(jsonData);
            } catch (error) {
                console.error('Error fetching data:', error);
                setData([]);
            }
        };

        fetchData();
    }, [url]);

    return data;
};

export default useFetchData;
