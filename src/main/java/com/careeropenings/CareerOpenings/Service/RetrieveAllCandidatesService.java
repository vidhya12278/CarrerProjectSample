package com.careeropenings.CareerOpenings.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.careeropenings.CareerOpenings.DTO.CandidateDTO;
import com.careeropenings.CareerOpenings.Repo.SaveCandidateRep;

@Service
public class RetrieveAllCandidatesService {
	private static final Logger logger = LoggerFactory.getLogger(RetrieveAllCandidatesService.class);

	private final SaveCandidateRep saveRep;

	public RetrieveAllCandidatesService(SaveCandidateRep saveRep) {
		this.saveRep = saveRep;
	}

	public Map<String, Object> retrieveAllCandidate() {
		LocalDate startDate = LocalDate.now().withDayOfMonth(1);
		LocalDate endDate = LocalDate.now().withDayOfMonth(startDate.lengthOfMonth());

		logger.info("Start Month : " + startDate + "End Month: " + endDate);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedStartDate = startDate.format(formatter);
		String formattedEndDate = endDate.format(formatter);

		LocalDate startedDate = LocalDate.parse(formattedStartDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate endedDate = LocalDate.parse(formattedEndDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		logger.info("startedDate : " + startedDate + "endedDate : " + endedDate);

		List<CandidateDTO> allData = saveRep.getAppliedCandidatesData(startedDate, endedDate).stream()
				.map(data -> new CandidateDTO(data[0].toString(), data[1].toString(), data[2].toString(),
						data[3].toString(), data[4].toString(), data[5].toString(), data[6].toString(),
						data[7].toString()))
				.collect(Collectors.toList());

		return Map.of("StatusCode", allData.isEmpty() ? "1" : "0", "Message", allData.isEmpty() ? "Failure" : "Success",
				"allData", allData.isEmpty() ? "No Records Found" : allData);

	}

	public Map<String, Object> filterCandidate(CandidateDTO candidateDTO) {
		String startedate = candidateDTO.getStartedate();
		String enddate = candidateDTO.getEnddate();
		LocalDate startedDate = LocalDate.parse(startedate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate endedDate = LocalDate.parse(enddate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		List<CandidateDTO> filterData = saveRep.filterCandidatesData(startedDate, endedDate).stream()
				.map(d -> new CandidateDTO(d[0].toString(), d[1].toString(), d[2].toString(), d[3].toString(),
						d[4].toString(), d[5].toString(), d[6].toString(), d[7].toString()))
				.collect(Collectors.toList());

		return Map.of("StatusCode", filterData.isEmpty() ? "1" : "0", "Message",
				filterData.isEmpty() ? "Failure" : "Success", "filteredData",
				filterData.isEmpty() ? "No Records Found" : filterData);
	}

}
